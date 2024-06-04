//
//  Router.swift
//  iosApp
//
//  Created by Abdul Mateen on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

final class Router: ObservableObject{
    public enum Destination: Codable, Hashable {
        case sign_up
        case home
    }
    
    @Published var navPath = NavigationPath()
    
    func navigate(to destination: Destination){
        navPath.append(destination)
    }
    
    func navigateBack(){
        navPath.removeLast()
    }
    
    func navigateToRoot(){
        navPath.removeLast(navPath.count)
    }
    
    
}
