package com.example.dessertclicker.ui.test

import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.ui.DessertViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.jetbrains.annotations.TestOnly
import org.junit.Before
import org.junit.Test

class DessertViewModelTest {

    private lateinit var viewModel: DessertViewModel

    @Before
    fun setup()
    {
        viewModel = DessertViewModel()
    }

    @Test
    fun dessertViewModel_initialState_isCorrect() =  runTest{
        val uiState = viewModel.dessertUiState.value


        assertEquals(0,uiState.revenue)
        assertEquals(0,uiState.dessertsSold)
        assertEquals(0,uiState.currentDessertIndex)
        assertEquals(
            dessertList[0].imageId,
            uiState.currentDessertImageId
        )
        assertEquals(
            dessertList[0].price,
            uiState.currentDessertPrice
        )
    }




}