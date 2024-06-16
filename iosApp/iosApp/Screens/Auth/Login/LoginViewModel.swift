//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Abdul Mateen on 09/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
final class LoginViewModel: ObservableObject {
    @Published var email: String = ""
    @Published var password: String = ""
    @Published var isLoading: Bool = false
    @Published var error: String?
    @Published var isLoggedIn: Bool = false
    let helper: KoinHelper = KoinHelper()
    
    func onLoginClick(){
        Task{
            do{
                isLoading = true
                let response = try await helper.login(email: email, password: password)
                isLoading = false
                print("User Data: \(response)")
                isLoggedIn = true
            }catch{
                self.error = error.localizedDescription
            }
        }
    }
}
