//
//  LoginView.swift
//  iosApp
//
//  Created by Abdul Mateen on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    @EnvironmentObject var router: Router
    
    var body: some View {
        VStack{
            
            Button("**Go to home**"){
                router.navigate(to: .home)
            }
            .padding()
            .background(.blue)
            .foregroundColor(.white)
            .cornerRadius(10)
            Button("SignUp") {
                
                router.navigate(to: .sign_up)
            }
        }
    }
}

#Preview {
    LoginView()
}
