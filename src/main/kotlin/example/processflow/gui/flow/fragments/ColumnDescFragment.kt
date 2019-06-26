package example.processflow.gui.flow.fragments

import example.processflow.ProcessDefinitionModel
import javafx.scene.paint.Color
import tornadofx.*

class ColumnDescFragment : Fragment() {

    private val model: ProcessDefinitionModel by inject()

    override val root = stackpane {
        svgpath("M 20 50 L 0 20 L 230 20 L 250 50 L 230 80 L 0 80 Z") {
            stroke = Color.LIGHTBLUE
            fill = Color.LIGHTBLUE
            strokeWidth = 2.0

        }
        label(model.name){
            style{
                textFill = Color.WHITE
            }
        }
    }


}
