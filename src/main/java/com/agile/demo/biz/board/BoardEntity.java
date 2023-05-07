package com.agile.demo.biz.board;

import com.agile.demo.biz.account.AccountEntity;
import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AccountEntity userId;
}
