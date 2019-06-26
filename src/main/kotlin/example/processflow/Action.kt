package example.processflow

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import tornadofx.*

class Action {

    val name: StringProperty = SimpleStringProperty()
    val description: StringProperty = SimpleStringProperty()

    constructor(name: String = "", description: String = ""){
        this.name.value = name
        this.description.value = description
    }

    override fun toString(): String {
        return "$name.value  [ $description.value ]"
    }
}

