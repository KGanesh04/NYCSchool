package com.wal.nycs

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class DataViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val testScope = TestCoroutineScope(testDispatcher)

    @Mock
    private lateinit var mockApiService: ApiService

    private lateinit var viewModel: DataViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = DataViewModel(mockApiService)
    }

    @Test
    fun fetchData_success() = testScope.runBlockingTest {
        val testDataList = listOf(Data("1", "Test Name"))
        `when`(mockApiService.getData()).thenReturn(Response.success(testDataList))

        viewModel.fetchData()

        // Verify if dataList is updated with the test data list
        assertEquals(viewModel.dataList.value, testDataList)
    }

    @Test
    fun fetchData_failure() = testScope.runBlockingTest {
        `when`(mockApiService.getData()).thenReturn(Response.error(404, null))

        viewModel.fetchData()

        // Verify if dataList is null in case of failure
        assertEquals(viewModel.dataList.value, null)
    }
}