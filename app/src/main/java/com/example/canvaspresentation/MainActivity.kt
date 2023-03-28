package com.example.canvaspresentation

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // TODO: example for Canvas - basic shapes
            FRTLogo()

            // TODO: example for Canvas - path
//            DrawPath()
        }
    }
}


@Composable
fun FRTLogo() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .padding(32.dp)
//                .offset {
//                    IntOffset(offsetX.roundToInt(), offsetY.roundToInt())
//                }
                .size(100.dp)

            // TODO: show both ways of dragging an object
            // TODO: First way - draggable

//                .draggable(
//                    state = rememberDraggableState  { delta ->
//                        offsetX += delta
//                    },
//                    orientation = Orientation.Horizontal
//                )

            // TODO: Second way - pointerInput

//                .pointerInput(Unit) {
//                    detectDragGestures { change, dragAmount ->
//                        change.consume()
//                        offsetX += dragAmount.x
//                        offsetY += dragAmount.y
//                    }
//                }
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(size.width - 3.dp.toPx(), 0f),
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height),
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, size.height),
                end = Offset(size.width - 3.dp.toPx(), size.height),
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(size.width - 3.dp.toPx(), 0f),
                end = Offset(size.width - 3.dp.toPx(), size.height - 28.dp.toPx()),
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Square
            )
            drawLine(
                color = Color.Black,
                start = Offset(size.width - 3.dp.toPx(), size.height),
                end = Offset(size.width - 3.dp.toPx(), size.height - 5.dp.toPx()),
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Square
            )

            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "flat",
                    size.width - 93.dp.toPx(),
                    size.height - 70.dp.toPx(),
                    Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 25.sp.toPx()
                        typeface = Typeface.DEFAULT_BOLD
                    }
                )
                drawText(
                    "rock",
                    size.width - 93.dp.toPx(),
                    size.height - 40.dp.toPx(),
                    Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 25.sp.toPx()
                        typeface = Typeface.DEFAULT_BOLD
                    }
                )
                drawText(
                    "technology",
                    size.width - 93.dp.toPx(),
                    size.height - 10.dp.toPx(),
                    Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 25.sp.toPx()
                        typeface = Typeface.DEFAULT_BOLD
                    }
                )
            }
        }
    }
}

@Composable
fun DrawPath() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(
                start = 32.dp,
                top = 32.dp,
                bottom = 32.dp
            )
    ) {
        Canvas(modifier = Modifier.size(width = 200.dp, height = 250.dp)) {
            val rectSide = 30.dp.toPx()
            val iconWidth = 200
            val path = Path().apply {
                // Top left arc
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = 30f,
                        right = rectSide,
                        bottom = rectSide + 30f
                    ),
                    startAngleDegrees = 180.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                lineTo(x = (size.width - iconWidth) + iconWidth / 3, y = 30f)
                lineTo(x = size.width - iconWidth / 2, y = 0f)
                lineTo(x = size.width - iconWidth / 3, y = 30f)
                //Top right arc
                arcTo(
                    rect = Rect(
                        left = size.width - rectSide,
                        top = 30f,
                        right = size.width,
                        bottom = rectSide + 30f
                    ),
                    startAngleDegrees = -90.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                lineTo(x = size.width, y = size.height - rectSide)
                // Bottom right arc
                arcTo(
                    rect = Rect(
                        left = size.width - rectSide,
                        top = size.height - rectSide,
                        right = size.width,
                        bottom = size.height
                    ),
                    startAngleDegrees = 0.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                lineTo(x = size.width - rectSide, y = size.height)
                // Bottom left arc
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = size.height - rectSide,
                        right = rectSide,
                        bottom = size.height
                    ),
                    startAngleDegrees = 90.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                lineTo(x = 0f, y = size.height - rectSide)
                close()
            }

            drawPath(
                path = path,
                color = Color.Black,
                style = Stroke(width = 3.dp.toPx())
            )
        }
    }
}