package com.eahm.animationexp.models

import com.eahm.animationexp.ui.MainActivity

data class MenuElement (
    val title: String = "",
    val subtitle: String  = "",
    val description: String  = "",
    val activity : Class<*> = MainActivity::class.java
)
