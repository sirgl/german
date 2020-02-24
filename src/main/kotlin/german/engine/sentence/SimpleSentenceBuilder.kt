package german.engine.sentence

//import german.engine.Sentence
//import german.engine.forms.Plurality
//import german.engine.traits.Subjectable
//import german.engine.words.Noun
//import german.engine.words.ArticleType
//import german.engine.words.Verb
//
//class SentenceBuilder {
//    var subject : SubjectInfo? = null
//    var predicate: Verb? = null
//    var plurality: Plurality? = null
//    var anObject: SubjectInfo? = null
//
//    fun build() : Sentence {
//        val subjectInfoValue = subject ?: throw IllegalArgumentException()
//        val predicateValue = predicate ?: throw IllegalArgumentException()
//        val pluralityValue = plurality ?: Plurality.Singular
//        val subjectValue = subjectInfoValue.subj ?: throw IllegalArgumentException()
//        val prepositionType = subjectInfoValue.articleType
//        val objNoun = anObject?.subj
//        val objPrepType = anObject?.articleType
//        if (objNoun !is Noun?) throw IllegalArgumentException()
//
//        return SimpleSentence(prepositionType, subjectValue, predicateValue, pluralityValue, objPrepType, objNoun)
//    }
//
//    fun subj(f: SubjectInfo.() -> Unit) {
//        val info = SubjectInfo()
//        f(info)
//        subject = info
//    }
//
//    fun obj(f: SubjectInfo.() -> Unit) {
//        val info = SubjectInfo()
//        f(info)
//        anObject = info
//    }
//}
//
//class SubjectInfo {
//    var subj: Subjectable? = null
//    var articleType: ArticleType? = null
//}
//
//fun simpleSentence(builder: SentenceBuilder.() -> Unit): Sentence {
//    val b = SentenceBuilder()
//    builder(b)
//    return b.build()
//}



// TODO too generic
//fun buildSentence(words: List<WordOrForm>, restrictions: List<Restriction>) {
//
//}