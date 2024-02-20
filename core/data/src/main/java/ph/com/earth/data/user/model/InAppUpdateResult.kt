package ph.com.earth.data.user.model

sealed class InAppUpdateResult {
    data object MandatoryUpdate : InAppUpdateResult()
    data object RecommendedUpdate : InAppUpdateResult()
    data object NoUpdate : InAppUpdateResult()
}