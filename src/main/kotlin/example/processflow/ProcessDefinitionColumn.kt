package example.processflow

import example.processflow.gui.flow.fragments.AddItemButtonFragment
import example.processflow.gui.flow.fragments.ColumnDescFragment
import example.processflow.gui.flow.fragments.ColumnListFragment
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.util.Duration
import tornadofx.*


class ProcessDefinitionColumn() : Fragment() {

    private val model: ProcessDefinitionModel by inject()

    override val root = vbox {

        val columnListScope = Scope()
        setInScope(model, columnListScope)

        this += find<ColumnDescFragment>(columnListScope)
        this += find<ColumnListFragment>(columnListScope)
        this += find<AddItemButtonFragment>(columnListScope)

        style {
            padding = box(0.px, 10.px)
            vgrow = Priority.ALWAYS
            hgrow = Priority.ALWAYS
         }


    }


}