package com.abdulmateen.kmpstartertemplate.screens.auth.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdulmateen.kmpstartertemplate.android.R

@Composable
fun SignUpScreen(
    onSignInClick: () -> Unit,
    onSuccessRegistration: () -> Unit
) {
    Scaffold {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
            )

            Button(onClick = onSuccessRegistration) {
                Text(text = stringResource(id = R.string.sign_up))
            }
            Button(onClick = onSignInClick) {
                Text(text = stringResource(id = R.string.sign_in))
            }
        }
    }
}


@Preview
@Composable
private fun RegisterScreenPreview() {
    SignUpScreen(
        onSignInClick = {},
        onSuccessRegistration = {}
    )
}