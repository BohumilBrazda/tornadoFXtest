package example.processflow.example.processflow.gui.flow.view

import example.processflow.*
import javafx.geometry.Pos
import javafx.scene.control.ListView
import javafx.scene.layout.HBox
import tornadofx.*

class MainView : View("Process Flow Test App") {

    private val listWidth = 200.0

    private lateinit var processesBox: HBox
    private val controller: ProcessDefinitionController by inject()

    override val root = hbox {
        drawer {
            item("Process Definitions", expanded = true) {
                listview(controller.getAllProcessTemplates()) {

                    prefWidth = listWidth
                    minWidth = listWidth

                    cellFormat {
                        graphic = form {
                            fieldset {
                                vbox {
                                    text(it.name) {
                                        style {
                                            alignment = Pos.BOTTOM_LEFT
                                            fontSize = 16.px
                                        }
                                    }
                                }
                            }
                        }
                    }

                    onUserSelect(clickCount = 2) {
                        controller.getAllProcesses().add(selectedItem)
                        val scope = creteScopeWithProcess(ProcessDefinition(selectedItem))

                        val newColumn = find<ProcessDefinitionColumn>(scope)
                        processesBox += newColumn


                    }
                }
            }
            item("Actions") {
                listview(controller.getAllActions()) {

                    prefWidth = listWidth
                    minWidth = listWidth

                    cellFormat {
                        graphic = form {
                            fieldset {
                                vbox {
                                    text(it.name) {
                                        style {
                                            alignment = Pos.BOTTOM_LEFT
                                            fontSize = 16.px
                                        }
                                    }
                                    text(it.description) {
                                        style {
                                            alignment = Pos.BOTTOM_LEFT
                                            fontSize = 12.px
                                        }
                                    }
                                }
                            }
                        }
                    }
                    onUserSelect(clickCount = 2) {
                        val selectedProcess = controller.selectedProcessDefinition
                        selectedProcess.actions.add(selectedItem)
                    }

                }
            }
            style {
                paddingBottom = 70
            }
        }

        processesBox = hbox() {
            for (process in controller.getAllProcesses()) {
                val scope = creteScopeWithProcess(process)
                this += find<ProcessDefinitionColumn>(scope)
            }
        }
    }

    private fun creteScopeWithProcess(process: ProcessDefinition?): Scope {
        val model = ProcessDefinitionModel(process)
        val scope = Scope()
        setInScope(model, scope)
        return scope

    }
}
