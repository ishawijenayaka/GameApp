package com.example.gameapp.core.commanComponents


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainTitle(
    modifier: Modifier = Modifier,
    title: String, maxLines: Int = 2,
    align : TextAlign = TextAlign.Start,
    lineHeight: TextUnit = 32.sp )
{
    Text (
        modifier = modifier
            .fillMaxWidth(),
        text = title,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary,
        maxLines = maxLines,
        textAlign = align,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis)
}

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    title: String, maxLines: Int = 5,
    align : TextAlign,
    lineHeight: TextUnit = 20.sp )
{
    Text (
        modifier = modifier,
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary,
        maxLines = maxLines,
        textAlign = align,
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis)
}

@Composable
fun SubText(
    modifier: Modifier = Modifier,
    title: String,
    maxLines: Int = 5,
    align : TextAlign = TextAlign.Start
)
{
    Text(
        modifier = modifier
                    .fillMaxWidth(),
        text = title,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.primary,
        textAlign = align,
        maxLines = maxLines,
        lineHeight = 12.sp,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun GeneralText(
    modifier: Modifier = Modifier.fillMaxWidth(),
    title: String,
    maxLines: Int = 50,
    align: TextAlign = TextAlign.Center,
    fontSize : TextUnit =  14.sp,
    fontWeight : FontWeight = FontWeight.Normal,
    textColor: Color = MaterialTheme.colorScheme.secondary,
)
{

    Text(
        modifier = modifier,
        text = title,
        fontSize = fontSize,
        fontWeight = fontWeight,
        softWrap = true, // Allow text wrapping.
        maxLines = maxLines,
        color = textColor,
        textAlign = align,
        lineHeight = 16.sp,
    )
}

