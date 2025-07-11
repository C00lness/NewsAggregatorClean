package com.example.newsaggregator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repository.News

@Composable
fun Item(item: News) {
    val localUriHandler = LocalUriHandler.current
    val reg = "\\<([^}]{1,10})\\>".toRegex()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.White)
            .clickable (onClick = {localUriHandler.openUri(item.guid.toString())}) ,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = item.title.substringAfter("."),
                color = Color.DarkGray,
                fontSize = 17.sp,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(color = Color.DarkGray, modifier = Modifier.fillMaxWidth().width(1.dp))
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                ImageItem(item.imageUrl)
                Text(
                    text = (item.details.replace(reg, "").substring(0, 120)).substringBeforeLast(" ") + " ...", //item.details.substring(0, 100)
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
            HorizontalDivider(color = Color.Red, modifier = Modifier.fillMaxWidth().width(1.dp))
            Text(
                text = item.pubDate,
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 2.dp)
            )
            Text(
                text = item.creator,
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.padding(10.dp, 2.dp)
            )
            LazyRow {
                items(item.categories)
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(horizontal = 5.dp, vertical = 8.dp)
                            .clip(RoundedCornerShape(32.dp))
                            .background(color = Color.Magenta),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Text(
                            it, modifier = Modifier.padding(10.dp),
                            color = Color.White,
                            fontSize = 13.sp
                            )
                    }
                }
            }
        }
    }
}