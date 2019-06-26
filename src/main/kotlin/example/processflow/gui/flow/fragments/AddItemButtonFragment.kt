package example.processflow.gui.flow.fragments

import example.processflow.Action
import example.processflow.ActionDialogFragment
import example.processflow.ActionModel
import example.processflow.ProcessDefinitionModel
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

class AddItemButtonFragment : Fragment() {

    private val model: ProcessDefinitionModel by inject()

    override val root = stackpane {
        button {
            svgpath("M 10 30 L 50 30 L 30 30 L 30 10 L 30 30 L 30 50 L 30 30 ") {
                stroke = Color.BLACK
                fill = Color.WHITE
                strokeWidth = 3.0
                paddingAll = 5
            }
            action{
                val actionModel = ActionModel(Action())
                val scope = Scope()
                setInScope(actionModel, scope)

                val dialog = find<ActionDialogFragment>(scope)
                dialog.openModal(block = true)

                if(actionModel.isValid){
                    model.actions.value.add(actionModel.item)
                }
            }
        }
        style{
            padding = box(10.px)
            hgrow = Priority.ALWAYS

        }
    }
}