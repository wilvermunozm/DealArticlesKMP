//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Wilver Muñoz on 26/09/25.
//

import SwiftUI
import Shared

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel : ArticlesViewModel
        @Published
        private(set) var articlesState : ArticlesState
        
        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        
        func startObserving() async {
            for await s in articlesViewModel.articlesState {
                self.articlesState = s
            }
        }
    }
}

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel : ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            if(viewModel.articlesState.isLoading) {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(
                    error: error
                )
            }
            
            if(!viewModel.articlesState.articles.isEmpty){
                ScrollView {
                    LazyVStack(spacing: 10){
                        ForEach(viewModel.articlesState.articles, id: \.self ) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }
        .task {
            await self.viewModel.startObserving()
        }
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct AppBar: View {
    var body: some View {
        VStack {
            Text("Articles")
        }
    }
}

struct ErrorMessage: View {
    var error: String
    
    var body: some View {
        Text("Error, Correeee!!! \(error)")
    }
}

struct ArticleItemView: View {
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.urlToImage)){ phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image loading failed")
                } else {
                    Loader()
                }
            }
            
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            
            Text(article.content)
            
            Text(article.publishedAt)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }
        .padding(16)
    }
}
