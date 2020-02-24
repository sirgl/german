package german.engine.sentence

import german.engine.WordForm

class Positioned<out T: WordForm<*>>(val form: T, val positionInSentence: Int)