/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.engine.benchmarks.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.fhir.FhirEngine
import com.google.android.fhir.engine.benchmarks.app.data.ResourcesDataProvider
import java.time.LocalDateTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Suppress("unused")
internal class SearchApiViewModel(
  private val resourcesDataProvider: ResourcesDataProvider,
  private val fhirEngine: FhirEngine,
) : ViewModel() {

  private val _detailMutableStateFlow = MutableStateFlow("")
  val detailStateFlow: StateFlow<String> = _detailMutableStateFlow.asStateFlow()

  init {
    viewModelScope.launch(benchmarkingViewModelWorkDispatcher) {
      _detailMutableStateFlow.value = "Search: ${LocalDateTime.now()}"
    }
  }
}
