//
//  AboutScreen.swift
//  iosApp
//
//  Created by Wilver Muñoz on 25/09/25.
//

import SwiftUI
import Shared

struct AboutScreen : View {
    private struct RowItem: Hashable{
        let title: String
        let detail: String
    }
    
    private let items : [RowItem] = {
        
        let platform = Platform()
        platform.logSystemInfo()
        
        var list: [RowItem] = [
            .init(title: "Name: ", detail: platform.systemName),
            .init(title: "Model: ", detail: platform.deviceName)
        ]
        return list
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                HStack(
                    alignment: .center
                ){
                    Text(item.title)
                    Text(item.detail)
                }.padding(5)
                    
            }
        }
    }
}
