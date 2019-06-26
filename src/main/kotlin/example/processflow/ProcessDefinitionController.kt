package example.processflow

import javafx.collections.ObservableList
import tornadofx.*

class ProcessDefinitionController : Controller() {

    private val processes: ObservableList<ProcessDefinition> = observableListOf()
    private val processTemplates: ObservableList<ProcessDefinition> = observableListOf()
    private val actions: ObservableList<Action> = observableListOf()

    var selectedProcessDefinition: ProcessDefinition

    private val actionsA = listOf(
            Action("Enter Request Details", "Enter Request Details")

    ).asObservable()

    private val actionsB = listOf(
            Action("Create Vendors", "Create Vendors"),
            Action("Wait for approvals", "Wait for approvals"),
            Action("Run", "Run process")
    ).asObservable()

    init {
        processes.add(ProcessDefinition("Request Entry", actionsA))
        processes.add(ProcessDefinition("Vendor Addition", actionsB))

        processTemplates.add(ProcessDefinition("Request Entry", observableListOf<Action>()))
        processTemplates.add(ProcessDefinition("Vendor Addition", observableListOf<Action>()))
        processTemplates.add(ProcessDefinition("Send Email", observableListOf<Action>()))
        processTemplates.add(ProcessDefinition("Authenticate", observableListOf<Action>()))
        processTemplates.add(ProcessDefinition("Print document", observableListOf<Action>()))

        actions.addAll(actionsA)
        actions.addAll(actionsB)

        selectedProcessDefinition = processes.get(0)
    }


    fun getAllProcesses(): ObservableList<ProcessDefinition> {
        return processes
    }

    fun getAllProcessTemplates(): ObservableList<ProcessDefinition> {
        return processTemplates
    }

    fun getAllActions(): ObservableList<Action> {
        return actions
    }


}