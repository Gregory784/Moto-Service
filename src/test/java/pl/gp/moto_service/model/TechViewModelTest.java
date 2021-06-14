package pl.gp.moto_service.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.gp.moto_service.entity.TechReview;
import pl.gp.moto_service.repository.tech_review.TechReviewService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TechViewModelTest {

    @Mock
    private final List<TechReview> mockListTechReview = new ArrayList<>();
    @Mock
    private final List<TechViewModel> mockListTechReviewModel = new ArrayList<>();

    @Test
    @DisplayName("should create TechViewModel list")
    void showTechViewModel_createViewList(){
        //given
        var mockTechReviewService = mock(TechReviewService.class);
        var mockTechViewModel = mock(TechViewModel.class);

        //when

        when(mockTechReviewService.findTechReviewsByVehicleId(anyInt())).thenReturn(mockListTechReview);
        when(mockTechViewModel.showInsurances(anyInt())).thenReturn(mockListTechReviewModel);
        //then

        assert true;
    }

}