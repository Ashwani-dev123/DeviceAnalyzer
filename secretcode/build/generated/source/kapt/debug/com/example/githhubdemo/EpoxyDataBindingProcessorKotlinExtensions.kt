@file:Suppress("DEPRECATION")

package com.example.githhubdemo

import com.airbnb.epoxy.ModelCollector
import kotlin.Suppress
import kotlin.Unit

public inline
    fun ModelCollector.cpuProgress(modelInitializer: CpuProgressBindingModelBuilder.() -> Unit):
    Unit {
  add(
  CpuProgressBindingModel_().apply {
    modelInitializer()
  }
  )
}

public inline
    fun ModelCollector.information(modelInitializer: InformationBindingModelBuilder.() -> Unit):
    Unit {
  add(
  InformationBindingModel_().apply {
    modelInitializer()
  }
  )
}

public inline
    fun ModelCollector.listLayout(modelInitializer: ListLayoutBindingModelBuilder.() -> Unit):
    Unit {
  add(
  ListLayoutBindingModel_().apply {
    modelInitializer()
  }
  )
}
