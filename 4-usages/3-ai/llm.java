///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS dev.langchain4j:langchain4j-bom:1.0.0@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-ollama
//DEPS org.slf4j:slf4j-simple:2.0.17

import static java.lang.System.out;
import static java.time.Duration.ofSeconds;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;

/**
 * LangChain4jを使ってOllamaのローカルLLMに
 * アクセスするサンプル。
 * 
 * Llama3.2モデルに飲み物の作り方を聞く。
 */
public class llm {
    // OllamaのURL
    static final String OLLAMA_URL = "http://localhost:11434";
    // 使用するモデル
    static final String MODEL = "llama3.2";

    /**
     * LangChain4jにはAIサービスという機能が
     * あって、インタフェースを定義するだけで
     * 自動でチャットモデルとのやり取りを
     * 実装してくれる。
     */
    public static void main(String... args) {
        var model = OllamaChatModel.builder()
                .baseUrl(OLLAMA_URL)
                .modelName(MODEL)
                .timeout(ofSeconds(60 * 3))
                .build();
        var assistant = AiServices.builder(Assistant.class)
                .chatModel(model)
                .build();
        var dish = args.length > 0 ? args[0] : "コーヒー";
        out.println(assistant.recipe(dish));
    }

    /**
     * AIサービスのインタフェース。
     * システムプロンプトもアノテーションで
     * 定義できる。
     */
    interface Assistant {
        @SystemMessage("""
                飲み物の作り方を教えてください。
                """)
        String recipe(String query);
    }
}
