package example.processflow

import javafx.geometry.Pos
import javafx.scene.control.ButtonBar
import javafx.scene.layout.Priority
import tornadofx.*

class ActionDialogFragment : Fragment("Edit Action") {

    private val model: ActionModel by inject()

    override val root = form {
        fieldset {
            fieldset {

               field("Name: ") {
                    textfield(model.name).required()
                }
                field("Description") {
                    textfield(model.description).required()
                }
                alignment = Pos.TOP_CENTER
            }


            buttonbar {
                button("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE).setOnAction{
                    model.rollback()
                    close()
                }
                button("OK", ButtonBar.ButtonData.OK_DONE).setOnAction {
                    enableWhen(model.valid)
                    model.commit {
                        close()
                    }
                }
                paddingTop = 10
                alignment = Pos.BOTTOM_RIGHT

            }
            vgrow = Priority.ALWAYS

            model.validate(decorateErrors = false)
        }
    }
}
