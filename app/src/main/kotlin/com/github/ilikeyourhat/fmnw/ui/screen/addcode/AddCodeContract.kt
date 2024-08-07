package com.github.ilikeyourhat.fmnw.ui.screen.addcode

data class AddCodeScreenState(
    val name: String = "",
    val value: String = ""
)

interface AddCodeEvents {
    fun onCodeNameChanged(name: String)
    fun onCodeValueChanged(value: String)
    fun onDoneClicked()
    fun onCloseClicked()

    companion object {
        val DUMMY = object : AddCodeEvents {
            override fun onCodeNameChanged(name: String) = Unit
            override fun onCodeValueChanged(value: String) = Unit
            override fun onDoneClicked() = Unit
            override fun onCloseClicked() = Unit
        }
    }
}