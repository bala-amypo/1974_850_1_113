

🔹 6. SERVICE FILES (Constructor Injection ✔)
service/StudentProfileService.java
 


service/IntegrityCaseService.java
 


service/EvidenceRecordService.java
 
@Service
public class EvidenceRecordService {

private final EvidenceRecordRepository repo;

public EvidenceRecordService(EvidenceRecordRepository repo) {
this.repo = repo;
}
}

service/PenaltyActionService.java
 
@Service
public class PenaltyActionService {

private final PenaltyActionRepository repo;

public PenaltyActionService(PenaltyActionRepository repo) {
this.repo = repo;
}
}

service/RepeatOffenderRecordService.java
 
@Service
public class RepeatOffenderRecordService {

public int computeRepeatOffenderRecord(int cases) {
if (cases <= 1) return 1;
if (cases == 2) return 2;
return 4;
}
}



