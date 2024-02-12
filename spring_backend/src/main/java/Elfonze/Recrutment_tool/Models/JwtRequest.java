package Elfonze.Recrutment_tool.Models;

import lombok.*;

import javax.xml.transform.sax.SAXTransformerFactory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {
    private String username;
    private String password;
}
