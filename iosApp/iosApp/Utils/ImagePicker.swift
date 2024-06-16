//
//  ImagePicker.swift
//  iosApp
//
//  Created by Abdul Mateen on 09/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ImagePicker: UIViewControllerRepresentable {
    @Environment(\.presentationMode) private var presentationMode
    var sourceType: UIImagePickerController.SourceType = .camera
    @Binding var selectedImage: UIImage

    func makeUIViewController(context: UIViewControllerRepresentableContext<ImagePicker>) -> UIImagePickerController {
            let imagePicker = UIImagePickerController()
            imagePicker.allowsEditing = false
            imagePicker.sourceType = sourceType
            imagePicker.delegate = context.coordinator
            
            return imagePicker
    }

    func updateUIViewController(_ uiViewController: UIImagePickerController, context: UIViewControllerRepresentableContext<ImagePicker>) {

    }

    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }

    final class Coordinator: NSObject, UIImagePickerControllerDelegate, UINavigationControllerDelegate {

        var parent: ImagePicker

        init(_ parent: ImagePicker) {
            self.parent = parent
        }

        func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
            if(UIImagePickerController.isSourceTypeAvailable(parent.sourceType)){
                if let image = info[UIImagePickerController.InfoKey.originalImage] as? UIImage {
                    parent.selectedImage = image
                }
            }else{
                print("Source type is not available")
            }

            parent.presentationMode.wrappedValue.dismiss()
        }

    }
}
