//
//  SignUpViewModel.swift
//  iosApp
//
//  Created by Abdul Mateen on 09/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
class SignUpViewModel: ObservableObject{
    @Published var email: String = ""
    @Published var dateOfBirth: Date = Date()
    @Published var password: String = ""
    @Published var confirmPassword: String = ""
    
    func onSignUpClick(){
        print("Sign Up button clicked")
    }
}
