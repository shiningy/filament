/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.filament.tungsten.model

import com.google.android.filament.MaterialInstance

sealed class PropertyValue {

    abstract fun applyToMaterialInstance(materialInstance: MaterialInstance, name: String)
}

data class Float3(val x: Float = 0.0f, val y: Float = 0.0f, val z: Float = 0.0f) : PropertyValue() {

    override fun applyToMaterialInstance(materialInstance: MaterialInstance, name: String) {
        materialInstance.setParameter(name, x, y, z)
    }
}

enum class PropertyType {
    GRAPH_PROPERTY,
    MATERIAL_PARAMETER
}

data class Property(
    val name: String,
    val value: PropertyValue,
    val type: PropertyType = PropertyType.GRAPH_PROPERTY
)
