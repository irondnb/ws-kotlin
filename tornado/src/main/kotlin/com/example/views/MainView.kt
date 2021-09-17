package com.example.views

import com.example.controllers.AppController
import tornadofx.*

class MainView : View() {
    val controller: AppController by inject()
    val bottomView: SubmitFormView by inject()

    override fun onDock() {
        runLater { controller.connect() }
    }

    override val root = borderpane {
        center = listview<String>(controller.chatMessages)
        bottom = bottomView.root
    }
}