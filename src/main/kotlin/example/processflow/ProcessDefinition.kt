package example.processflow

import javafx.collections.ObservableList
import tornadofx.*

class ProcessDefinition{

    private val defaultName = ""

    var name: String = defaultName
    val actions: ObservableList<Action> = observableListOf()


    constructor(name: String, actions: List<Action>){
        this.name = name
        this.actions.addAll(actions)
    }

    constructor(processDefinition: ProcessDefinition?){
        name = processDefinition!!.name
        actions.addAll(processDefinition.actions)
    }

    fun getAllActions(): ObservableList<Action> {
        return actions
    }

    fun addAction(action: Action){
        this.actions.add(action)
    }
}


