//
//  DataState.swift
//  iosApp
//
//  Created by Abdul Mateen on 16/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

enum DataState{
    case loading
    case data(User)
    case error(String)
}
