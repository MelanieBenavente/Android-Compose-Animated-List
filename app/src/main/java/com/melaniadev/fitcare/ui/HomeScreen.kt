package com.melaniadev.fitcare.ui

import android.util.Log
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
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
import kotlin.math.roundToInt


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    val navigationController = rememberNavController()
    CustomerListScreen(navigationController = navigationController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerListScreen(
    navigationController: NavHostController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val listState = rememberLazyListState()
    val isItemVisible = remember { mutableStateMapOf<Int, Boolean>() }
    val animationFinishedHashMap = remember { mutableStateMapOf<Int, Boolean>() }

    LaunchedEffect(Unit) {
        animationFinishedHashMap[0] = true
    }

    Scaffold(modifier = Modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .fillMaxSize(),
        topBar = {
            TopBarBackButton(
                isNavigable = false,
                navController = navigationController,
                title = stringResource(R.string.home_top_bar_title),
                scrollBehavior = scrollBehavior
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                state = listState
            ) {
                item {
                    Column {
                        SearchBarComponent(
                            iconDrawable = R.drawable.search_vector,
                            text = "Search patients",
                            contentDescription = "Search patients"
                        )
                        FilterItemsBarComponent()

                    }
                }

                itemsIndexed(mockList()) { actualIndex, customer ->
                    AnimatedItemListComponent(
                        actualIndex,
                        customer,
                        isItemVisible,
                        listState,
                        animationFinishedHashMap,
                        navigationController
                    )
                }
            }
        })
}

@Composable
private fun AnimatedItemListComponent(
    actualIndex: Int,
    customer: Customer,
    isItemVisible: SnapshotStateMap<Int, Boolean>,
    listState: LazyListState,
    animationFinishedHashMap: SnapshotStateMap<Int, Boolean>,
    navigationController: NavHostController
) {
    val correctedIndex =
        if (actualIndex == listState.layoutInfo.totalItemsCount) listState.layoutInfo.totalItemsCount else actualIndex + 1

    listState.layoutInfo.visibleItemsInfo.forEach {
        Log.e(
            "control", "listado " + it.index
        )
    }
    val isVisible = remember {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.filter { correctedIndex == it.index }
                .firstOrNull() != null
        }
    }

    if (correctedIndex <= listState.firstVisibleItemIndex) {
        isItemVisible[correctedIndex] = true
        animationFinishedHashMap[correctedIndex - 1] = true
    }

    if (isVisible.value) {
        isItemVisible[correctedIndex] = true
        animationFinishedHashMap[listState.firstVisibleItemIndex] = true
    } else {
        isItemVisible[correctedIndex] = false
    }

    Log.e("control", "index = " + correctedIndex)
    val initPx = with(LocalDensity.current) {
        350.dp.toPx().roundToInt()
    }
    val targetValue =
        if (isItemVisible[correctedIndex] == true && (correctedIndex == 0 || animationFinishedHashMap[correctedIndex - 1] == true)) {
            Log.e("control", "index = " + correctedIndex + "assigned px 0")

            0
        } else {
            Log.e("control", "index = " + correctedIndex + "assigned px 350")
            initPx
        }

    val offset by animateIntAsState(targetValue = targetValue,
        label = "offset",
        animationSpec = tween(
            durationMillis = if (listState.isScrollInProgress) 200 else 50
        ),
        finishedListener = {
            Log.e(
                "control", "animation finished: " + correctedIndex
            )
            animationFinishedHashMap[correctedIndex] = true
        })

    Box(modifier = Modifier
        .fillMaxWidth()
        .offset(x = offset.dp)
        .clickable { navigationController.navigate("DetailScreen/") }) {
        ItemCustomerComponent(customer, navigationController)
    }
}

@Composable
private fun ItemCustomerComponent(customer: Customer, navigationController: NavHostController) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier

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
    val itemList = listOf(
        FilterBarItem(title = "Assigned Professional", filterAction = {}),
        FilterBarItem(title = "Next Visit Date", filterAction = {}),
        FilterBarItem(title = "Add Visit", filterAction = {})
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyRow(
            state = rememberLazyListState()
        ) {
            items(itemList.size) { index ->
                val item = itemList[index]
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier
                    .background(
                        grayComponentsBackground, RoundedCornerShape(8.dp)
                    )
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