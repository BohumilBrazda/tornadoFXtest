package example.processflow

import tornadofx.*

class ProcessDefinitionModel(processDefinition: ProcessDefinition?) : ItemViewModel<ProcessDefinition>(processDefinition) {
    val name = bind(ProcessDefinition::name)
    val actions = bind(ProcessDefinition::actions)
}