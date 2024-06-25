package com.melaniadev.fitcare.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.melaniadev.fitcare.R
import com.melaniadev.fitcare.ui.components.ActionButtonsComponent
import com.melaniadev.fitcare.ui.components.LeftIconInfoComponent
import com.melaniadev.fitcare.ui.components.LeftImageInfoComponent
import com.melaniadev.fitcare.ui.components.TopBarBackButton
import com.melaniadev.fitcare.ui.theme.localCustomColorsPalette

val visitHistoryMocked = listOf(
    Visit(
        typeOfVisit = "Massage Therapy", date = "Apr 24, 2023"
    ), Visit(
        typeOfVisit = "Acupunture", date = "Feb 10, 2025"
    )
)

val mockedCustomer = Customer(
    customerName = "Ava Smith",
    lastVisit = null,
    nextVisit = null,
    professional = Professional("Dr. Mathews", Therapy.PHYSICAL, null),
    gender = Gender.FEMALE,
    age = "32",
    weight = "42",
    height = "1.50",
    email = "lavienvert@gmail.com",
    phone = "635 23 96 35",
    imageUrl = "https://picsum.photos/200/300",
    visitHistory = visitHistoryMocked
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailPreview() {
    val navigationController = rememberNavController()
    DetailCustomerScreen(navigationController = navigationController, "")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCustomerScreen(navigationController: NavHostController, name: String) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        TopBarBackButton(
            navigationController,
            title = stringResource(R.string.user_profile_top_bar_title),
            scrollBehavior = scrollBehavior
        )
    }, content = { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(enabled = true, state = rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            DetailScreenUserImage(customer = mockedCustomer)
            InfoBioComponent(customer = mockedCustomer)
            ActionButtonsComponent(navigationController = navigationController)
            mockedCustomer.email?.let {
                LeftIconInfoComponent(
                    iconDrawable = R.drawable.email_vector,
                    contentDescription = "Email",
                    header = "Email",
                    body = it
                )
            }
            mockedCustomer.phone?.let {
                LeftIconInfoComponent(
                    iconDrawable = R.drawable.phone_vector,
                    contentDescription = "Phone number",
                    header = "Phone",
                    body = it
                )
            }
            AssignedProfessionalComponent(customer = mockedCustomer)
            VisitHistoryComponent(customer = mockedCustomer)
        }
    })
}

@Composable
fun DetailScreenUserImage(customer: Customer) {
    Box(
        modifier = Modifier.background(color = Color.Transparent)
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = customer.imageUrl,
            contentDescription = "Image profile",
            modifier = Modifier
                .clip(CircleShape)
                .height(115.dp)
                .width(115.dp)
        )
    }
}

@Composable
fun InfoBioComponent(customer: Customer) {
    Column() {
        Text(
            text = customer.name, style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = customer.gender.genderType + ", " + customer.age + " years old",
            style = MaterialTheme.typography.bodyMedium,
            color = localCustomColorsPalette.current.customTextColor

        )
        Text(
            text = customer.height + " cm" + " | " + customer.weight + " kg",
            style = MaterialTheme.typography.bodyMedium,
            color = localCustomColorsPalette.current.customTextColor
        )
    }
}

@Composable
fun AssignedProfessionalComponent(customer: Customer) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Text(
            text = "Assigned Professional",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        LeftImageInfoComponent(
            imageUrl = "https://picsum.photos/200/300",
            header = customer.professional.name,
            body = customer.professional.therapyType?.therapyType.orEmpty()
        )
    }
}

@Composable
fun VisitHistoryLazyColumn(visits: List<Visit>?) {
    val visitList = mockedCustomer.visitHistory ?: emptyList()
    Column {
        visitList.forEach { visit ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = visit.typeOfVisit, style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = visit.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = localCustomColorsPalette.current.customTextColor
                )
            }
        }
    }
}

@Composable
fun VisitHistoryComponent(customer: Customer) {
    Text(
        text = "Visit History",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(top = 20.dp)
    )
    VisitHistoryLazyColumn(visits = customer.visitHistory)
}



