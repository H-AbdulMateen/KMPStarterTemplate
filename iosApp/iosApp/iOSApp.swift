import SwiftUI

@main
struct iOSApp: App {
    @ObservedObject var router = Router()
    
	var body: some Scene {
		WindowGroup {
            NavigationStack(path: $router.navPath){
                LoginView()
                    .navigationDestination(for: Router.Destination.self){destination in
                        switch destination{
                        case .sign_up:
                            SignUpView()
                        case .home:
                            HomeView()
                        }
                    }
            }.environmentObject(router)
		}
	}
}
