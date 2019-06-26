package example.processflow.gui.flow.fragments

import example.processflow.*
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*


class ColumnListFragment: Fragment("Custom Column View") {

    private val model: ProcessDefinitionModel by inject()
    private val controller : ProcessDefinitionController by inject()

    override val root = listview(model.actions.value) {
        cellFormat {
            graphic = form {
                    fieldset {
                        vbox{
                            text(it.name) {

                                style {
                                    alignment = Pos.BOTTOM_LEFT
                                    fontSize = 16.px
                                }
                            }
                            text(it.description) {

                                style {
                                    alignment = Pos.BOTTOM_RIGHT
                                    fontSize = 12.px
                                }
                            }
                        }
                    }
                }

        }
        style{
            vgrow = Priority.ALWAYS
        }
        onUserSelect(clickCount = 2) {

            if (selectedItem != null) {

                val actionModel = ActionModel(selectedItem as Action)
                val scope = Scope()
                setInScope(actionModel, scope)
                val dialog = find<ActionDialogFragment>(scope)
                dialog.openModal(block = true)
            }
        }

    }

    override fun onDock() {

        currentStage?.focusedProperty()?.onChangeOnce {
            controller.selectedProcessDefinition = model.item
        }
    }

}


