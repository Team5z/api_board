package com.agile.demo.biz.backlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/backlogs")
public class BacklogController {

    @Autowired
    private BacklogService backlogService;

    @PostMapping// 백로그 생성하기
    public ResponseEntity<?> createProject(@RequestBody BacklogDto backlogDto) {
        BacklogEntity backlogEntity = backlogService.createBacklog(backlogDto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping // 백로그 출력하기 - 전체
    public List<BacklogEntity> getAllBacklog() {
        return backlogService.getAllBacklog();
    }

    @GetMapping("/{nb_seq}") // 백로그 출력 - 한개 확대시
    public ResponseEntity<BacklogEntity> getOneBacklog(@PathVariable long nb_seq) {
        BacklogEntity backlogEntity = backlogService.getBacklogById(nb_seq);
        return ResponseEntity.ok(backlogEntity);
    }

    @PutMapping("{nb_seq}") // 백로그 수정
    public ResponseEntity<?> updateBacklog(@PathVariable long nb_seq, @RequestBody BacklogDto backlogDto) {
        BacklogEntity backlogEntity = backlogService.updateBacklog(nb_seq, backlogDto);
        return ResponseEntity.ok(backlogEntity);
    }

    @DeleteMapping("/{nb_seq}") // 백로그 삭제하기
    public ResponseEntity deleteProject(@PathVariable long nb_seq){
        backlogService.deleteBacklog(nb_seq);
        return ResponseEntity.accepted().build();
    }
}
