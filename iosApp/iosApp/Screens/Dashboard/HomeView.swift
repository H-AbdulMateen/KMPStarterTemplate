//
//  HomeView.swift
//  iosApp
//
//  Created by Abdul Mateen on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    @EnvironmentObject var router: Router
    var body: some View {
        Text("Home View")
            .navigationTitle("")
            .navigationBarBackButtonHidden(true)
        VStack{
        
            
            Button {
                router.navigateBack()
            } label: {
                Text("**Logout**")
                    .padding()
                    .background(.red)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .shadow(color: .red, radius: /*@START_MENU_TOKEN@*/10/*@END_MENU_TOKEN@*/, y: 5)

        }

    }
}

#Preview {
    HomeView()
}
