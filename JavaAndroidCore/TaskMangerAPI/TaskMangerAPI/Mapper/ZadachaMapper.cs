using AutoMapper;
using TaskMangerAPI.Entities;
using TaskMangerAPI.Models.Zadachi;

namespace TaskMangerAPI.Mapper;

public class ZadachaMapper : Profile
{
    public ZadachaMapper()
    {
        CreateMap<ZadachaItemModel, ZadachaEntity>().ReverseMap();
        CreateMap<ZadachaCreateModel, ZadachaEntity>()
            .ForMember(dest => dest.Image, opt => opt.Ignore());
        CreateMap<ZadachaUpdateModel, ZadachaEntity>()
            .ForMember(dest => dest.Id, opt => opt.Ignore())
            .ForMember(dest => dest.Image, opt => opt.Ignore());
    }
}
