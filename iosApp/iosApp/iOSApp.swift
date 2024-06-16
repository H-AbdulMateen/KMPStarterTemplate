import SwiftUI
import shared
@main
struct iOSApp: App {
    @ObservedObject var router = Router()
    
    init(){
        KoinHelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            NavigationStack(path: $router.navPath){
                LoginView(viewModel: .init())
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
