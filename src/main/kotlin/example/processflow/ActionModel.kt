package example.processflow

import tornadofx.*

class ActionModel(action: Action) : ItemViewModel<Action>(action) {
    val name = bind(Action::name)
    val description = bind(Action::description)
}
