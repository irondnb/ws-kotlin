package com.example.views

import com.example.controllers.SubmitFormController
import tornadofx.*

class SubmitFormView : View() {
    private val controller: SubmitFormController by inject()
    override val root = borderpane {
        top = buttonbar {
            button("Emoji") {
                println("TODO: open modal with emojis")
            }
        }
        center = form {
            fieldset {
                val textField = textarea()
                buttonbar {
                    button("Send") {
                        action { controller.submit(textField) }
                    }
                }
                shortcut("ENTER") { controller.submit(textField) }
            }
        }
    }
}
