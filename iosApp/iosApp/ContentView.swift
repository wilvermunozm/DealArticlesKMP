import SwiftUI
import Shared

struct ContentView: View {
    
    @State private var shouldOpenabout = false
    
    var body: some View {
        NavigationStack{
            ArticlesScreen(viewModel: .init())
                .toolbar{
                    ToolbarItem {
                        Button{
                            shouldOpenabout.toggle()
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented : $shouldOpenabout) {
                            AboutScreen()
                        }
                    }
                }
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
