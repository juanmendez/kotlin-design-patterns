package info.juanmendez.kotlin.designpatterns.creation

data class BodyBuilder(
    val squats: Boolean,
    val preacherCurls: Boolean,
    val armExtension: Boolean,
    val militaryPress: Boolean,
    val deadLift: Boolean,
    val benchPress: Boolean
){
    /**
     * When considering a builder, we should focus on whether or not the construction is complex.
     * If we have too simple construction patterns then the effort of creating our
     * flexible builder object may far exceed the benefit.
     * @see [builder-design-pattern](https://www.baeldung.com/kotlin-builder-pattern)
     */
    data class Instance(
        private var squats: Boolean = false,
        private var preacherCurls: Boolean = false,
        private var armExtension: Boolean = false,
        private var militaryPress: Boolean = false,
        private var deadLift: Boolean = false,
        private var benchPress: Boolean = false
    ) {
        fun squats(canDo: Boolean) = apply {
            squats = canDo
        }

        fun preacherCurls(canDo: Boolean) = apply {
            preacherCurls = canDo
        }

        fun armExtension(canDo: Boolean) = apply {
            armExtension = canDo
        }

        fun militaryPress(canDo: Boolean) = apply {
            militaryPress = canDo
        }

        fun deadLift(canDo: Boolean) = apply {
            deadLift = canDo
        }

        fun benchPress(canDo: Boolean) = apply {
            benchPress = canDo
        }

        /**
         * IDEAL: include requirements to prevent creating object
         */
        fun create(): BodyBuilder {
            return BodyBuilder(
                squats,
                preacherCurls,
                armExtension,
                militaryPress,
                deadLift,
                benchPress
            )
        }
    }
}