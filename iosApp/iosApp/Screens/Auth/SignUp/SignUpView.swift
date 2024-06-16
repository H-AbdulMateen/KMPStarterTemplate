//
//  SignUpView.swift
//  iosApp
//
//  Created by Abdul Mateen on 02/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SignUpView: View {
    @State private var image = UIImage()
    @State private var showSheet = false
    @State private var cameraPreview = false
    @State private var showChooseImageSource = false
    @State private var sourceType:  UIImagePickerController.SourceType = .camera
    @State private var selectedDate: Date = Date()
    @EnvironmentObject var router: Router
    
    var body: some View {
        VStack {
            Image(uiImage: self.image)
                .resizable()
                .frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/, height: 100)
                .background(.black.opacity(0.2))
                .aspectRatio(contentMode: /*@START_MENU_TOKEN@*/.fill/*@END_MENU_TOKEN@*/)
                .clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
                .overlay(Circle().stroke(.red, lineWidth: 2))
                .onTapGesture {
                    showChooseImageSource = true
                }
                .actionSheet(isPresented: $showChooseImageSource, content: {
                    ActionSheet(title: Text("Image Picker"),
                                        message: Text("Choose a source for image picker"),
                                        buttons: [
                                            .cancel(),
                                            .default(
                                                Text("Camera").foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/),
                                                action: {
                                                    if(UIImagePickerController.isSourceTypeAvailable(.camera)){
                                                        sourceType = .camera
                                                        showSheet = true
                                                    }else{
                                                        print("Camera is not available")
                                                    }
                                                }
                                            ),
                                            .default(
                                                Text("Photo Library"),
                                                action: {
                                                    sourceType = .photoLibrary
                                                    showSheet = true
                                                }
                                            )
                                        ]
                            )
                })
                .fullScreenCover(isPresented: $showSheet) {
                            // Pick an image from the photo library:
                    ImagePicker(sourceType: .photoLibrary, selectedImage: self.$image)

                            //  If you wish to take a photo from camera instead:
                            // ImagePicker(sourceType: .camera, selectedImage: self.$image)
                    }
            
            TextField("Email", text: /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Value@*/.constant("")/*@END_MENU_TOKEN@*/)
                .padding(.top,16)
            Divider()
            
            DatePicker(selection: $selectedDate,
                       displayedComponents: .date,
                       label: { Text("Date Of Birth") })

            .padding(.top, 10)
            Divider()
            SecureField("Password", text: /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Value@*/.constant("Apple")/*@END_MENU_TOKEN@*/)
                .padding(.top, 10)
            Divider()
            SecureField("Confirm Password", text: /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Value@*/.constant("Apple")/*@END_MENU_TOKEN@*/)
                .padding(.top, 10)
            Divider()
            
            Button("Register") {
                /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Action@*/ /*@END_MENU_TOKEN@*/
            }
            .padding(.top, 16)
            Button("Already, have an account? Login"){
                router.navigateBack()
            }
            .foregroundColor(.green)
            Spacer()
                }
            .padding(.horizontal, 20)
    }
}

#Preview {
    SignUpView()
}
