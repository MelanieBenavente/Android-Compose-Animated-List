package com.melaniadev.fitcare.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.melaniadev.fitcare.R
import com.melaniadev.fitcare.ui.components.PersonalInfoComponent
import com.melaniadev.fitcare.ui.components.SearchBarComponent
import com.melaniadev.fitcare.ui.components.TopBarBackButton
import com.melaniadev.fitcare.ui.theme.grayComponentsBackground


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    val navigationController = rememberNavController()
    CustomerListScreen(navigationController = navigationController)
}

@Composable
private fun CustomerListScreenComponents(
    customersList: List<Customer>, navigationController: NavHostController, modifier: Modifier) {
    LazyColumn(modifier = modifier.clickable { navigationController.navigate("DetailScreen") }) {

        item {
            SearchBarComponent(
                iconDrawable = R.drawable.search_vector,
                text = "Search patients",
                contentDescription = "Search patients"
            )
        }
        item {
            FilterItemsBarComponent()
        }
        items(customersList) {
            ItemCustomerComponent(it, navigationController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerListScreen(navigationController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopBarBackButton(
            isNavigable = false,
            navController = navigationController,
            title = stringResource(R.string.home_top_bar_title),
            scrollBehavior = scrollBehavior
        )
    }, content = { padding ->
        CustomerListScreenComponents(
            modifier = Modifier.padding(padding),
            customersList = mockList(),
            navigationController = navigationController
        )
    })
}

@Composable
private fun ItemCustomerComponent(customer: Customer, navigationController: NavHostController) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { navigationController.navigate(Routes.CUSTOMER_DETAIL.name + "/${customer.name}") }
            .fillMaxWidth()
            .padding(all = 16.dp)) {
        Box(
            modifier = Modifier.background(color = Color.Transparent)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = "https://picsum.photos/200/300",
                contentDescription = "Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(74.dp)
                    .width(74.dp)

            )
        }
        PersonalInfoComponent(
            modifier = Modifier.padding(start = 15.dp, top = 12.dp),
            header = customer.name,
            bodyFirstLine = customer.gender.genderType + " | Age: " + customer.age,
            bodySecondLine = "Assigned to: " + customer.professional.name,
            bodyThirstLine = "Last visit: " + customer.lastVisit
        )
    }
}

@Composable
private fun FilterItemsBarComponent() {
    val itemList = listOf(FilterBarItem(title = "Assigned Professional", filterAction = {}),
                          FilterBarItem(title = "Next Visit Date", filterAction = {}),
                          FilterBarItem(title = "Add Visit", filterAction = {})
    )
    Box(modifier = Modifier.fillMaxWidth().padding(top = 7.dp, bottom = 5.dp), contentAlignment = Alignment.Center) {
        LazyRow(
            state = rememberLazyListState()
        ) {
            items(itemList.size) { index ->
                val item = itemList[index]
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier
                    .background(
                        grayComponentsBackground, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .clickable { item.filterAction() }) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
            }
        }
    }
}