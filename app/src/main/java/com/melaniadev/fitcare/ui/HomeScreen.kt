package com.melaniadev.fitcare.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.melaniadev.fitcare.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    val navigationController = rememberNavController()
    CustomerListScreen(customersList = mockList(), navigationController = navigationController)
}

@Composable
fun CustomerListScreen(customersList: List<Customer>, navigationController: NavHostController) {
    LazyColumn(modifier = Modifier.clickable { navigationController.navigate("DetailScreen") }) {
        item {
            CustomerListHeader()
        }
        items(customersList) {
            ItemCustomerComponent(it, navigationController)
        }
    }
}

@Composable
fun CustomerListHeader(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 10.dp)
        ) {
        Text(text = stringResource(R.string.customer_name), style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1.5f))
        Text(text = stringResource(R.string.last_visit), style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1.5f))
        Text(text = stringResource(R.string.next_visit), style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1.5f))
        Text(text = stringResource(R.string.physiotherapist_name), style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1.5f))
    }

}

@Composable
fun ItemCustomerComponent(customer: Customer, navigationController: NavHostController){
    Row(modifier = Modifier
        .clickable { navigationController.navigate(Routes.CUSTOMER_DETAIL.name + "/${customer.name}") }
        .fillMaxWidth()
        .padding(all = 10.dp)
    ) {
        Text(text = customer.name, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        customer.lastVisit?.let {
            Text(text = customer.lastVisit, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        }
        customer.nextVisit?.let{
            Text(text = customer.nextVisit, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        }
        Text(text = customer.professional.name, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
    }
}
