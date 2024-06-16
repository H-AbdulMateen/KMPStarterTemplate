//
//  LoginView.swift
//  iosApp
//
//  Created by Abdul Mateen on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginView: View {
    @ObservedObject private(set) var viewModel: LoginViewModel = LoginViewModel()
    
    @EnvironmentObject var router: Router
    
    var body: some View {
        VStack{
            TextField("Email", text: $viewModel.email)
                Divider()
            SecureField("Password", text: $viewModel.password)
                .padding(.top, 8)
            Divider()
            if(viewModel.isLoading){
                ProgressView()
            }else{
                Button("**Login**"){
                    viewModel.onLoginClick()
    //                router.navigate(to: .home)
                }.padding(EdgeInsets(top: 16, leading: 12, bottom: 8, trailing: 12))
                    .background(.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            if let error = viewModel.error {
                Text(error)
                    .foregroundColor(.red)
                    .padding()
            }
            Button("SignUp") {
                
                router.navigate(to: .sign_up)
            }
        }.padding()
    }
}


#Preview {
    LoginView()
}
